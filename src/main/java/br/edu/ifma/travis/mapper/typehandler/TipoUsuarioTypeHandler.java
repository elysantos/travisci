package br.edu.ifma.travis.mapper.typehandler;

import br.edu.ifma.travis.model.TipoUsuario;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TipoUsuarioTypeHandler extends BaseTypeHandler<TipoUsuario> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, TipoUsuario tipoUsuario, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, tipoUsuario.getId());
    }

    @Override
    public TipoUsuario getNullableResult(ResultSet resultSet, String s) throws SQLException {
        TipoUsuario tipoUsuario = TipoUsuario.valueOf(resultSet.getInt(s));
        return resultSet.wasNull() ? null : tipoUsuario;
    }

    @Override
    public TipoUsuario getNullableResult(ResultSet resultSet, int i) throws SQLException {
        TipoUsuario tipoUsuario = TipoUsuario.valueOf(resultSet.getInt(i));
        return resultSet.wasNull() ? null : tipoUsuario;
    }

    @Override
    public TipoUsuario getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        TipoUsuario tipoUsuario = TipoUsuario.valueOf(callableStatement.getInt(i));
        return callableStatement.wasNull() ? null : tipoUsuario;
    }
}
