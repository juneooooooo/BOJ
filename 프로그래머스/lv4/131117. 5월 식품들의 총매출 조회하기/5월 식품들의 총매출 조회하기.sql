SELECT O.PRODUCT_ID, P.PRODUCT_NAME, (P.PRICE*O.SUM_AMOUNT) as TOTAL_SALES
FROM FOOD_PRODUCT P
JOIN (SELECT PRODUCT_ID, SUM(AMOUNT) as SUM_AMOUNT
      FROM FOOD_ORDER
      WHERE PRODUCE_DATE like '2022-05%'
      GROUP BY PRODUCT_ID) O
ON P.PRODUCT_ID = O.PRODUCT_ID
ORDER BY TOTAL_SALES desc, PRODUCT_ID

