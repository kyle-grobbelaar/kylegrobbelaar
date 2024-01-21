package com.enviro.assessment.grad001.kylegrobbelaar.persistence;

import com.enviro.assessment.grad001.kylegrobbelaar.model.WithdrawalNotice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * WithdrawalNotice Data Access Object - stores in memory every WithdrawalNotice Entity
 */
@Repository
public interface WithdrawalNoticeDAO extends JpaRepository<WithdrawalNotice, Long> {
}
