package com.example.gticslab420213852.Repository;

import com.example.gticslab420213852.Entity.JobHistory;
import com.example.gticslab420213852.Entity.JobHistoryId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobHistoryRepository extends JpaRepository<JobHistory, JobHistoryId> {
}