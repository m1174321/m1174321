




import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fh.book.book.mapper.IBookMapper;
import com.fh.book.book.po.Book;
import com.fh.book.book.vo.BookVO;
import com.fh.book.book.vo.bookParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-common.xml"})
public class test extends AbstractJUnit4SpringContextTests {

   @Autowired
    private IBookMapper bookMapper;

    @Test
    public void test() {
        
        BookVO bookVO = new BookVO();
        bookVO.setDraw(0);
        bookVO.setStart(0);
        bookVO.setLength(10);
        Wrapper<Book> wrapper = bookParam.wrapper(bookVO);
        IPage<Book> bookIPage = bookMapper.selectPage(new Page<Book>(bookVO.getStart(), bookVO.getLength()), wrapper);
        List<Book> records = bookIPage.getRecords();
        System.out.println(records);
    }


}
