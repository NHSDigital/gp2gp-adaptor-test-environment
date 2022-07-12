package com.benhession.mockspinemhsoutbound.service;

import static com.benhession.mockspinemhsoutbound.util.MustacheUtil.fillTemplate;
import static com.benhession.mockspinemhsoutbound.util.MustacheUtil.loadTemplate;

import org.springframework.stereotype.Service;

import com.benhession.mockspinemhsoutbound.model.SuccessTemplateParams;
import com.github.mustachejava.Mustache;

@Service
public class SpineResponseService {

    private static final Mustache SUCCESS_TEMPLATE = loadTemplate("async_reliable_success_response.mustache");

    public String fillSuccessTemplate(SuccessTemplateParams params) {
        return fillTemplate(SUCCESS_TEMPLATE, params);
    }
}
