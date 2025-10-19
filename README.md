# DataOps Cloud Suite

## Overview

**DataOps Cloud Suite** is a distributed, multi-language platform designed to demonstrate a complete DevOps + Data + Observability architecture.  
It combines modern technologies used in enterprise systems, with an emphasis on scalability, monitoring, and maintainability.

This project is deployed on a Linux (Lubuntu) environment or via public cloud hosting.  
It integrates Java (Spring Boot), Python (FastAPI), and Angular, supported by PostgreSQL and a full observability stack.

---

## System Architecture

```text
                     ┌────────────────────────────┐
                     │         Frontend           │
                     │ Angular 18 + Chart.js      │
                     └────────────┬───────────────┘
                                  │
                         REST / WebSocket
                                  │
        ┌─────────────────────────┴─────────────────────────┐
        │                   API Gateway                     │
        │ Spring Cloud Gateway (JWT / OAuth2 / CORS)        │
        └──────────────┬────────────────────────────────────┘
                       │
       ┌───────────────┼──────────────────────────┐
       │               │                          │
┌──────▼───────┐ ┌─────▼───────────┐ ┌────────────▼─────────┐
│ Metrics Svc  │ │ Alerts Service  │ │ Data Worker (ETL)    │
│ Spring Boot  │ │ ASP.NET Core 7  │ │ FastAPI + Pandas     │
│ PostgreSQL   │ │ Kafka Consumer  │ │ Kafka Producer        │
│ Kafka Client │ │ SignalR / WS    │ │ Cron Scheduler        │
└──────┬───────┘ └─────┬───────────┘ └────────────┬─────────┘
       │                │                          │
       └────────────────┴──────────────────────────┘
                       │
               Apache Kafka Cluster
                       │
                PostgreSQL Database
                       │
  ┌────────────────────────────────────────────┐
  │     DevOps / Infrastructure & Monitoring   │
  │--------------------------------------------│
  │ Linux (Lubuntu)                            │
  │ Docker & Docker Compose                    │
  │ Jenkins / GitHub Actions (CI/CD)           │
  │ Prometheus + Grafana                       │
  │ Loki + ELK Stack                           │
  │ Vault (Secrets Management)                 │
  └────────────────────────────────────────────┘
Technical Stack
Domain	Technologies	Purpose
Frontend	Angular 18, Chart.js	User interface and dashboards
Backend	Spring Boot 3, Spring Data JPA	REST API, authentication, persistence
Data Layer	FastAPI (Python 3.11), Pandas	ETL, data collection and transformation
Database	PostgreSQL	Relational data storage
CI/CD	GitHub Actions / Jenkins	Automated build and deployment pipelines
Infrastructure	Docker, Docker Compose	Containerized environment
Monitoring	Prometheus, Grafana	Metrics and system monitoring
Logging	Loki, ELK Stack	Centralized log management
Security	Vault, JWT, OAuth2	Secrets management and authentication
OS / Platform	Linux (Lubuntu)	Local or VM-based environment
Repository Structure
dataops-dashboard/
│
├── backend/                  # Java (Spring Boot 3)
│   ├── src/main/java/
│   ├── pom.xml
│   └── Dockerfile
│
├── frontend/                 # Angular 18
│   ├── src/
│   ├── angular.json
│   ├── package.json
│   └── Dockerfile
│
├── python-etl/               # FastAPI (Python 3.11)
│   ├── app/main.py
│   ├── requirements.txt
│   └── Dockerfile
│
├── .github/workflows/
│   └── ci-cd.yml             # CI/CD configuration
│
└── README.md

Local Development Setup
1. Prerequisites

Java 21

Node.js 20+ and Angular CLI

Python 3.11

PostgreSQL

Docker / Docker Compose (optional for local orchestration)

2. Backend
cd backend
./mvnw spring-boot:run

3. Frontend
cd frontend
npm install
ng serve --open

4. Python ETL Service
cd python-etl
pip install -r requirements.txt
uvicorn app.main:app --reload

CI/CD Workflow

Observability & Monitoring
Prometheus

Collects metrics from:

Spring Boot Actuator (/actuator/prometheus)

Kafka exporter

PostgreSQL exporter

Node exporter (for host metrics)

Grafana

Visual dashboards for:

CPU, memory, network usage

API latency per service

Kafka lag and throughput

PostgreSQL query rates

Loki / ELK

Centralized log aggregation

Search and filtering for errors across services

Security

JWT / OAuth2 for authentication

HTTPS via Traefik or Certbot

Vault for secrets management

.env files for local environment variables

Engineering Value
Domain	Demonstrated Skill
Software Architecture	Multi-service architecture with REST communication
Backend Engineering	Spring Boot, JPA, JWT, Actuator
Data Engineering	Python ETL, Pandas, PostgreSQL
DevOps	CI/CD pipelines, Docker orchestration
Cloud Infrastructure	Deployment on Linux / Render
Monitoring	Metrics and logging stack
Security	OAuth2, Vault, SSL certificates
Design Principles	SOLID, design patterns (Factory, Strategy, Observer)
Example Linux Setup
sudo apt update && sudo apt upgrade -y
sudo apt install docker docker-compose openjdk-17-jdk nodejs npm python3-pip -y
sudo systemctl enable docker

Author

Project: DataOps Cloud Suite
Author: Karim Boualam
Version: v2 (Enterprise Edition)
Year: 2025
