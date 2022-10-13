package com.fundamentos.springboot.springdemo.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fundamentos.springboot.springdemo.dto.UserDto;
import com.fundamentos.springboot.springdemo.entity.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
	
	@Query("select u from User u where u.email =?1")
	Optional<User> findByEmail(String email);
	
	@Query("select u from User u where u.name like ?1% ")
	List<User> findAndSort(String name, Sort sort);
	
	List<User> findByName(String name);
	
	List<User> findByNameAndEmail(String name, String email);
	
	List<User> findByNameLike(String name);
	
	List<User> findByNameOrEmail(String name, String email);
	
	List<User> findByBirthDateBetween(LocalDate begin, LocalDate end);
	
	List<User> findByNameLikeOrderByIdDesc(String name);
	
	List<User> findByNameContainingOrderByIdAsc(String name);
	
	@Query("select new com.fundamentos.springboot.springdemo.dto.UserDto(u.id, u.name, u.birthDate) "
			+ "from User u "
			+ "where u.birthDate = :birthDayParam "
			+ "and u.email = :emailParam")
	Optional<UserDto> getAllByBirthDateAndEmail(@Param("birthDayParam") LocalDate birthDate, @Param("emailParam") String email);
	
	List<User> findAll();
}
