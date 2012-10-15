package com.quirklabs.mobileviews

import javax.servlet.http.HttpSession
import org.springframework.web.context.request.RequestContextHolder

class BrowserInterceptor {

    def afterInterceptor = { model, modelAndView ->

        if(modelAndView) {

            if(getSession().forceBrowser == 'mobile') modelAndView.viewName = '/mobile/' + modelAndView.viewName

            else if(getSession().forceBrowser == 'desktop') return

            else {
                if (request && MobileService.isMobile(request)) {
                    modelAndView.viewName = '/mobile/' + modelAndView.viewName
                }
            }
        }
    }

    private HttpSession getSession() {
        return RequestContextHolder.currentRequestAttributes().getSession()
    }
}
