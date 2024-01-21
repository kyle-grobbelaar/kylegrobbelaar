package com.enviro.assessment.grad001.kylegrobbelaar.persistence;

import com.enviro.assessment.grad001.kylegrobbelaar.model.WithdrawalNotice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WithdrawalNoticeDAO extends JpaRepository<WithdrawalNotice, Long> {
}
