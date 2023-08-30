package javaAssessment_30_aug;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrderedProductsDAO {
    private static String url ="jdbc:mysql://localhost:3306/gainsight";
    public void displayOrderedProductById(int productId){
        Product p = null;
        try (Connection con = DriverManager.getConnection(url, "root", "G@1nsight");
             PreparedStatement pst = con.prepareStatement("select product_name, product_price, ordered_date from product p join ordered_products op on p.prod_id = op.prod_id join orders o on op.order_id = o.order_id where productId = ?");) {

            pst.setInt(1,productId);
            ResultSet rs = pst.executeQuery();
            while(rs.next())
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getDouble(4)+" "+rs.getInt(5));
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void displayOrderedProductsByOrderDate(String orderDate){
        try (Connection con = DriverManager.getConnection(url, "root", "G@1nsight");
             PreparedStatement pst = con.prepareStatement("select product_name, product_price, product_desc, ordered_date from product join ordered_products on product.prod_id = ordered_products.prod_id join orders on ordered_products.order_id = orders.order_id where order_date=?")) {
            pst.setString(1, orderDate);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getDouble(4)+" "+rs.getInt(5));
            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
