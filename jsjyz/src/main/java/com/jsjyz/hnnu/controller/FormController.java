package com.jsjyz.hnnu.controller;


import com.jsjyz.hnnu.pojo.Form;
import com.jsjyz.hnnu.service.FormService;
import com.jsjyz.hnnu.vo.ErrorCode;
import com.jsjyz.hnnu.vo.FormVo;
import com.jsjyz.hnnu.vo.ResultResponse;
import org.apache.velocity.runtime.directive.contrib.For;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FormController {
    @Autowired
    private FormService formService;
    @PostMapping("/timeoption")
    public ArrayList<String> timeOption() {
        ArrayList<String> options = new ArrayList<>();
        options.add("下午3:00~4:00");
        options.add("下午4:00~5:00");
        options.add("下午5:00~6:00");
        return options;
    }
    @PostMapping("/form")
    public ResultResponse saveForm(@RequestBody FormVo formVo) {
    return formService.saveForm(formVo);
    }
    //<=======admin===========>
    @PostMapping("/admin/form/update")
    public ResultResponse update(@RequestBody Form form){
        return formService.update(form);
    }
    @GetMapping("/admin/form/getAllForms")
    public ResultResponse getAllForms(){
        return new ResultResponse(ErrorCode.SUCCESS,formService.getAllForms());
    }
    @PostMapping("/admin/form/delete")
    public ResultResponse delete(@RequestBody List<Form> forms){
        return formService.delete(forms);
    }
    @PostMapping("/admin/form/updateList")
    public ResultResponse updateList(@RequestBody List<Form> forms){
        return formService.updateList(forms);
    }

}
