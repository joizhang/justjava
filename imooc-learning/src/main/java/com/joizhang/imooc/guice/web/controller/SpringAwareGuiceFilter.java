package com.joizhang.imooc.guice.web.controller;

import com.google.inject.servlet.GuiceFilter;

import javax.servlet.annotation.WebFilter;

/**
 * @author imooc
 */
@WebFilter
public class SpringAwareGuiceFilter extends GuiceFilter {
}
