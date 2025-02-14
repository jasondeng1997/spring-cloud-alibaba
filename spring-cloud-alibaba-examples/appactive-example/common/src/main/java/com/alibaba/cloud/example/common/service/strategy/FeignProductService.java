/*
 * Copyright 2013-2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alibaba.cloud.example.common.service.strategy;

import java.util.List;

import com.alibaba.cloud.example.common.entity.Product;
import com.alibaba.cloud.example.common.entity.ResultHolder;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yuluo
 */

@FeignClient(name = "product")
public interface FeignProductService {

	@RequestMapping("/list/")
	ResultHolder<List<Product>> list();

	@RequestMapping("/detail/")
	ResultHolder<Product> detail(@RequestParam(name = "rId") String rId,
			@RequestParam(name = "pId") String pId);

	@RequestMapping("/detailHidden/")
	ResultHolder<Product> detailHidden(@RequestParam(name = "pId") String pId);

	@RequestMapping("/buy/")
	ResultHolder<String> buy(@RequestParam(name = "rpcType") String rpcType,
			@RequestParam(name = "rId") String rId,
			@RequestParam(name = "pId") String pId,
			@RequestParam(name = "number") Integer number);

}
