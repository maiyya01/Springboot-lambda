// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package com.example.aws.api.dao;

import com.example.aws.api.entity.Product;
import com.example.aws.api.entity.Products;

import java.util.Optional;

public interface ProductDao {
  Optional<Product> getProduct(String id);

  void putProduct(Product product);

  void deleteProduct(String id);

  Products getAllProduct();
}
