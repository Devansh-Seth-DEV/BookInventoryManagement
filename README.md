# 📚 Book Inventory Management System

> **Beyond the shelf:** A high-fidelity data retrieval system for tracking unique physical assets and inventory health.

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.0-brightgreen)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-17%2F21-orange)](https://www.oracle.com/java/)
![Version](https://img.shields.io/github/v/release/Devansh-Seth-DEV/BookInventoryManagement?label=Version)

---

## 📖 Overview

Modern bookstores don't just sell titles; they manage physical copies with unique conditions and histories. This platform transforms a static book list into a **dynamic searchable catalog**, linking metadata from authors, publishers, and professional reviewers with real-time operational intelligence.

Built with **Spring Boot** and hosted on **Aiven Cloud MySQL**, this system is architected for transparency, debuggability, and high-performance DTO projections.

---

## 🛠️ Core Functional Modules

### 🔍 1. Catalog & Discovery

* **Deep Search:** Retrieve books by ISBN, Author, or Category.
* **Rich Metadata:** Integrated author biographies and publisher details.
* **Social Proof:** Access professional reviews linked directly to specific titles.

### 📦 2. Physical Inventory & Operations

* **Asset Tracking:** Monitor specific physical copies and their unique conditions (New, Used, Rare).
* **Low-Stock Alerts:** Automated monitoring for items with quantity < 5 to prevent stock-outs.
* **Operational Health:** Real-time visibility into "Available" vs "Purchased" inventory.

### 👤 3. User & Transactional Intelligence

* **Profile Management:** Comprehensive user data and active session tracking.
* **Live Cart:** Real-time management of user intent and shopping sessions.
* **Purchase Audit Trail:** Complete history of every unique physical asset acquired by a user.

---

## 🚀 Technical Architecture

### **The Stack**

* **Framework:** Spring Boot (Jakarta EE)
* **Persistence:** Hibernate / Spring Data JPA
* **Database:** MySQL (Hosted on Aiven Cloud)
* **Testing:** JUnit 5, Mockito, MockMvc
* **Design Pattern:** Controller-Service-Repository-DTO

### **Key Patterns**
* **Constructor Projections:** Utilizes JPQL `SELECT NEW` for optimized data transfer, bypassing full entity hydration.
* **Strict Validation:** Uses `ddl-auto=validate` to ensure code-to-schema alignment in production environments.

---

## 🧪 Quality Assurance

Our testing suite ensures 100% isolation of the business layer:

* **Unit Testing:** Mockito mocks for all service-to-repository interactions.
* **Integration Testing:** MockMvc for verifying REST status codes and JSON structures.
* **Semantic Validation:** Explicit handling of `204 No Content` for empty states and `404 Not Found` for invalid IDs.
