package br.edu.ifma.travis.mapper.typehandler;

import br.edu.ifma.travis.model.Genero;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GeneroTypeHandler extends BaseTypeHandler<Genero> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Genero genero, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, genero.getId());
    }

    @Override
    public Genero getNullableResult(ResultSet resultSet, String s) throws SQLException {
        Genero genero = Genero.valueOf(resultSet.getInt(s));
        return  resultSet.wasNull() ? null : genero;
    }

    @Override
    public Genero getNullableResult(ResultSet resultSet, int i) throws SQLException {
        Genero genero = Genero.valueOf(resultSet.getInt(i));
        return  resultSet.wasNull() ? null : genero;
    }

    @Override
    public Genero getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        Genero genero = Genero.valueOf(callableStatement.getInt(i));
        return  callableStatement.wasNull() ? null : genero;
    }
}
