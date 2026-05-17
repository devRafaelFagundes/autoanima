package com.ieka.autoanima.repository;

import com.ieka.autoanima.domain.TimelineSegment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimelineSegmentRepository extends JpaRepository<TimelineSegment, Long> {
}
