package com.mason.alpha.mapper;

import com.mason.alpha.domain.Catalog;
import com.mason.alpha.infra.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CatalogMapper {

    private static String findNameStatement = "Select catalog_id, catalog_name, catalog_img_url " +
            "From " +
            "catalog " +
            "where catalog_name = ?";

    private static String updateStatementString = "UPDATE catalog " +
            "SET catalog_name = ? , catalog_img_url = ? " +
            "WHERE catalog_id =? ";

    public List findByName(String name) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List result = new ArrayList();
        try {
            stmt = DB.prepare(findNameStatement);
            stmt.setString(1, name);
            rs = stmt.executeQuery();
            while (rs.next()) {
                result.add(load(rs));
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.cleanUp(stmt, rs);
        }
        return result;
    }

    private Object load(ResultSet rs) throws SQLException {
        Long id = new Long(rs.getLong(1));
        Catalog catalog = doLoad(id, rs);
        return catalog;
    }

    private Catalog doLoad(Long id, ResultSet rs) throws SQLException {
        String name = rs.getString(2);
        String imgUrl = rs.getString(3);
        return new Catalog(id, name, imgUrl);

    }

    public void update(Catalog catalog) {
        PreparedStatement stmt = null;
        try {
            stmt = DB.prepare(updateStatementString);
            stmt.setString(1, catalog.getName());
            stmt.setString(2, catalog.getImageUrl());
            stmt.setLong(3, catalog.getId());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.cleanUp(stmt);
        }

    }
}
