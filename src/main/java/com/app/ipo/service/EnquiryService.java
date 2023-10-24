package com.app.ipo.service;

import java.util.List;

public interface EnquiryService {
    List<?> searchAllTablesByPan(String searchTerm);
    List<?> searchAllTablesByVpa(String searchTerm);
    List<?> searchAllTablesBySym(String searchTerm);
}
