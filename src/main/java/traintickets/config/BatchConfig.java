package traintickets.config;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.*;
import javax.swing.tree.RowMapper;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import lombok.RequiredArgsConstructor;
import traintickets.batch.TrajetProcessor;
import traintickets.batch.TrajetWriter;
import traintickets.commun.enums.TrainTypeEnum;
import traintickets.model.Train;
import traintickets.repository.TrainRepository;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	


	
	
	@Autowired
	private DataSource dataSource;
	

    
    
    @Bean
    public Job listTrajetsJob(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
        Step step = stepBuilderFactory.get("trajetStep")
                .<Train, Train> chunk(5)
                .reader(trainItemReader())
                .processor(new TrajetProcessor())
                .writer(new TrajetWriter())
                .build();
        return jobBuilderFactory.get("listTrajetsJob")
                .start(step)
                .build();
    }
    

	@Bean
	public ItemReader<Train> trainItemReader(){
		JdbcCursorItemReader<Train> cursorItemReader = new JdbcCursorItemReader<>();
		cursorItemReader.setDataSource(dataSource);
		cursorItemReader.setSql("SELECT person_id,first_name,last_name,email,age FROM person");
		//cursorItemReader.setRowMapper(new PersonRowMapper());
		return cursorItemReader;
	}
}

/*class TrainRowMapper implements RowMapper<Train> {

	@Autowired
	private TrainRepository trainRepository;
	
	public Train mapRow(ResultSet rs, int rowNum) throws SQLException {
		Train train = trainRepository.findByNum(rs.getString("NUM"));	
		return train;
	}

}*/
