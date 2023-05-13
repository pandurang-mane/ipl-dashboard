package com.pandurang.ipldashboard.config;

import com.pandurang.ipldashboard.CustomItemProcessor;
import com.pandurang.ipldashboard.JobCompletionNotificationListener;
import com.pandurang.ipldashboard.Match;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.*;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class SpringBatchConfig {

    private final String[] FIELD_NAMES = {"ID", "City", "Date", "Season", "MatchNumber", "Team1", "Team2", "Venue", "TossWinner", "TossDecision", "SuperOver", "WinningTeam", "WonBy", "Margin", "method", "Player_of_Match", "Team1Players", "Team2Players", "Umpire1", "Umpire2"};

    @Bean
    public ItemReader<RawMatch> itemReader()
            throws UnexpectedInputException, ParseException {
        return new FlatFileItemReaderBuilder<RawMatch>()
                .name("matchItemReader")
                .resource(new ClassPathResource("IPL_Matches_2008_2022.csv"))
                .delimited()
                .names(FIELD_NAMES)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<RawMatch>() {{
                    setTargetType(RawMatch.class);
                }})
                .linesToSkip(1)
                .build();
    }

    @Bean
    public CustomItemProcessor itemProcessor() {
        return new CustomItemProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Match> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Match>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO match (id, city, date, season, match_number, team1, team2, venue, toss_winner, toss_decision, super_over, winning_team, won_by, margin, method, player_of_match, team1players, team2players, umpire1, umpire2) " +
                        "VALUES (:id, :city, :date, :season, :matchNumber, :team1, :team2, :venue, :tossWinner, :tossDecision, :superOver, :winningTeam, :wonBy, :margin, :method, :playerOfMatch, :team1Players, :team2Players, :umpire1, :umpire2)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public Job importUserJob(JobRepository jobRepository,
                             JobCompletionNotificationListener listener, Step step1) {
        return new JobBuilder("importUserJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(JobRepository jobRepository,
                      PlatformTransactionManager transactionManager, JdbcBatchItemWriter<Match> writer) {
        return new StepBuilder("step1", jobRepository)
                .<RawMatch, Match>chunk(10, transactionManager)
                .reader(itemReader())
                .processor(itemProcessor())
                .writer(writer)
                .build();
    }

}