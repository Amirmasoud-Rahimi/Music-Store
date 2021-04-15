package com.demisco.project.repository;

import com.demisco.project.model.MembersVote;

import java.util.List;

/**
 * Custom Implementations for Spring Data Repositories:
 * When a query method requires a different behavior or
 * cannot be implemented by query derivation,
 * then it is necessary to provide a custom implementation
 *
 * @link <a
 * href="https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.custom-implementations">
 * Spring Data JPA Documentation</a>
 */
public interface CustomizedMembersVoteRepo {
    void memberVoteValidate(List<MembersVote> membersVote);
}