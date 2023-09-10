package spring.Pro_P_F.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.Pro_P_F.domain.Series;
import spring.Pro_P_F.repository.SeriesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SeriesService {

    @Autowired
    private SeriesRepository seriesRepository;

    public List<Series> getAllSeries() {
        return seriesRepository.findAll();
    }

    public void addSeries(String seriesName) {
        Series series = new Series();
        series.setS_name(seriesName);
        seriesRepository.save(series);
    }

    public void updateSeries(Long seriesId, String seriesName) {
        Optional<Series> optionalSeries = seriesRepository.findById(seriesId);
        if (optionalSeries.isPresent()) {
            Series series = optionalSeries.get();
            series.setS_name(seriesName);
            seriesRepository.save(series);
        }
    }

    // 다른 메서드 (시리즈 삭제, 시리즈 조회 등)도 추가 가능
}
