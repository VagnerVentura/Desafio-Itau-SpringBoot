package desafio.itau.springboot.dto;

import java.util.DoubleSummaryStatistics;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatisticsResponse {

	private long count;
	private double sum;
	private double avg;
	private double min;
	private double max;	
	
	public StatisticsResponse(DoubleSummaryStatistics stats) {
		this.count = stats.getCount();
		this.sum = stats.getSum();
		this.avg = stats.getAverage();
		this.min = stats.getMin();
		this.max = stats.getMax();
	}
	
}
