package pt.ua.es.labProject.dao;

import javax.persistence.Query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pt.ua.es.labProject.model.UserModel;

@Repository
public interface UserDao extends JpaRepository<UserModel, Integer>{

	Query createQuery(String string);


}
