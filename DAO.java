package loneDruid;

import java.util.List;

public interface DAO {
    //增加
    public void add(PunchMan hero);
    //修改
    public void update(PunchMan hero);
    //删除
    public void delete(int id);
    //获取
    public PunchMan get(int id);
    //查询
    public List<PunchMan> list();
    //分页查询
    public List<PunchMan> list(int start, int count);
}
