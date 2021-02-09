package com.aleksandar.documentweb.repositories;

import com.aleksandar.documentweb.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document,Long> {
}
