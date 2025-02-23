package com.irn.users.infrastructure.adapter.out.persistence.repository;

import com.irn.users.infrastructure.adapter.out.persistence.model.UserEntity;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPagingRepository extends ListPagingAndSortingRepository<UserEntity, Long> {

}
