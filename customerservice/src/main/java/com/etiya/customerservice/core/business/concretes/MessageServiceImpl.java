package com.etiya.customerservice.core.business.concretes;

import com.etiya.customerservice.core.business.abstracts.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class MessageServiceImpl implements MessageService {
    private MessageSource messageSource;
    @Override
    public String getMessage(String key) {
        return messageSource.getMessage(key,null, LocaleContextHolder.getLocale());
    }
}
