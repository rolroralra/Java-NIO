package nio;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class NioTest {
	public static void main(String[] args) throws Exception {
		
		Path filePath = Paths.get("C:/Users/Shinyoung.Kim/KSY/workspace_java/KOITP/src/test.txt");
		System.out.println(filePath.toAbsolutePath());
		System.out.println("파일 명: " + filePath.getFileName());    // 파일명 리턴
        System.out.println("부모 디렉토리 명: " + filePath.getParent().getFileName()); // 부모 객체의 이름 리턴
        System.out.println("중첩 경로 수: " + filePath.getNameCount());
 
        System.out.println();
        for (int i = 0; i < filePath.getNameCount(); i++) {
            System.out.println(filePath.getName(i));
        }
 
        System.out.println();
        Iterator<Path> iterator = filePath.iterator();
        while (iterator.hasNext()) {
            Path tmp = iterator.next();
            System.out.println(tmp.getFileName());
        }
        
        System.out.println(filePath);
        System.out.println("디렉토리 여부: " + Files.isDirectory(filePath));
        System.out.println("파일 여부: " + Files.isRegularFile(filePath));
        System.out.println("마지막 수정 시간: " + Files.getLastModifiedTime(filePath));
        System.out.println("파일 크기: " + Files.size(filePath));
        System.out.println("소유자: " + Files.getOwner(filePath));
        System.out.println("숨김 파일 여부: " + Files.isHidden(filePath));
        System.out.println("읽기 가능 여부: " + Files.isReadable(filePath));
        System.out.println("쓰기 가능 여부: " + Files.isWritable(filePath));


        
        System.out.println();
        System.out.println();
        
        FileSystem fileSystem = FileSystems.getDefault();
        
        for (FileStore store : fileSystem.getFileStores()) {
            System.out.println("드라이버명: " + store.name());
            System.out.println("파일시스템: " + store.type());
            System.out.println("전체 공간: " + store.getTotalSpace() + " 바이트");
            System.out.println("사용 중인 공간: " + (store.getTotalSpace() - store.getUnallocatedSpace()) + " 바이트");
            System.out.println("사용 가능한 공간: " + (store.getTotalSpace() - store.getUsableSpace()) + " 바이트");
            System.out.println();
        }
 
        System.out.println("파일 구분자: " + fileSystem.getSeparator());
        System.out.println();
 
        for (Path path : fileSystem.getRootDirectories()) {
            System.out.println(path.toString());
        }


	}
}
