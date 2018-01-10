package com.ssh.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestExcelFile {
	
/*	//默认单元格内容为数字时格式  
    private static DecimalFormat df = new DecimalFormat("0");  
    // 默认单元格格式化日期字符串   
    private static SimpleDateFormat sdf = new SimpleDateFormat(  "yyyy-MM-dd HH:mm:ss");   
    // 格式化数字  
    private static DecimalFormat nf = new DecimalFormat("0.00"); 
	public static void main(String[] args) {
		String fileName = "E:/test/产品参数2.xlsx";
		boolean isE2007 = false;    //判断是否是excel2007格式  
        if(fileName.endsWith("XLSX"))  
            isE2007 = true;
        
        
        try {  
            InputStream input = new FileInputStream(fileName);  //建立输入流  
            Workbook wb  = null;  
            //根据文件格式(2003或者2007)来初始化  
            if(isE2007)  
                wb = new XSSFWorkbook(input);  
            else  
                wb = new HSSFWorkbook(input);  
            Sheet sheet = wb.getSheetAt(0);     //获得第一个表单  
            Iterator<Row> rows = sheet.rowIterator(); //获得第一个表单的迭代器  
            while (rows.hasNext()) {  
                Row row = rows.next();  //获得行数据  
                System.out.println("Row #" + row.getRowNum());  //获得行号从0开始  
                Iterator<Cell> cells = row.cellIterator();    //获得第一行的迭代器  
                while (cells.hasNext()) {  
                    Cell cell = cells.next();  
                    System.out.println("Cell #" + cell.getColumnIndex());  
                    switch (cell.getCellType()) {   //根据cell中的类型来输出数据  
                    case XSSFCell.CELL_TYPE_NUMERIC:  
                        System.out.println(cell.getNumericCellValue());  
                        break;  
                    case XSSFCell.CELL_TYPE_STRING:  
                        System.out.println(cell.getStringCellValue());  
                        break;  
                    case XSSFCell.CELL_TYPE_BOOLEAN:  
                        System.out.println(cell.getBooleanCellValue());  
                        break;  
                    case XSSFCell.CELL_TYPE_FORMULA:  
                        System.out.println(cell.getCellFormula());  
                        break;  
                    default:  
                        System.out.println("unsuported sell type");  
                    break;  
                    }  
                }  
            }  
        } catch (IOException ex) {  
            ex.printStackTrace();  
        }  
		
		
		
		try{  
            ArrayList<ArrayList<Object>> rowList = new ArrayList<ArrayList<Object>>();  
            ArrayList<Object> colList;  
            XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(fileName));  
            XSSFSheet sheet = wb.getSheetAt(0);  
            XSSFRow row;  
            XSSFCell cell;  
            Object value;  
            for(int i = sheet.getFirstRowNum() , rowCount = 0; rowCount < sheet.getPhysicalNumberOfRows() ; i++ ){  
                row = sheet.getRow(i);  
                colList = new ArrayList<Object>();  
                if(row == null){  
                    //当读取行为空时  
                    if(i != sheet.getPhysicalNumberOfRows()){//判断是否是最后一行  
                        rowList.add(colList);  
                    }  
                    continue;  
                }else{  
                    rowCount++;  
                }  
                for( int j = row.getFirstCellNum() ; j <= row.getLastCellNum() ;j++){  
                    cell = row.getCell(j);  
                    if(cell == null || cell.getCellType() == XSSFCell.CELL_TYPE_BLANK){  
                        //当该单元格为空  
                        if(j != row.getLastCellNum()){//判断是否是该行中最后一个单元格  
                            colList.add("");  
                        }  
                        continue;  
                    }  
                    switch(cell.getCellType()){  
                     case XSSFCell.CELL_TYPE_STRING:    
                                
                            value = cell.getStringCellValue();    
                            System.out.println(i + "行" + j + " 列 is String type，" + value);
                            break;    
                        case XSSFCell.CELL_TYPE_NUMERIC:    
                        	System.out.println("========" + cell.getCellStyle());
                        	System.out.println("===222=====" + cell.getCellStyle().getDataFormatString());
                            if ("@".equals(cell.getCellStyle().getDataFormatString())) {    
                                value = df.format(cell.getNumericCellValue());    
                            } else if ("General".equals(cell.getCellStyle()    
                                    .getDataFormatString())) {    
                                value = nf.format(cell.getNumericCellValue());    
                            } else {    
                                value = sdf.format(HSSFDateUtil.getJavaDate(cell    
                                        .getNumericCellValue()));    
                            }    
                            value = nf.format(cell.getNumericCellValue()); 
                            System.out.println(i + "行" + j    
                                    + " 列 is Number type ; DateFormt:"    
                                    + value.toString());   
                            break;    
                        case XSSFCell.CELL_TYPE_BOOLEAN:    
                            value = Boolean.valueOf(cell.getBooleanCellValue());
                            System.out.println(i + "行" + j + " 列 is Boolean type，" + value); 
                            break;    
                        case XSSFCell.CELL_TYPE_BLANK:    
                        	System.out.println(i + "行" + j + " 列 is Blank type");    
                            value = "";    
                            break;    
                        default:    
                                
//                            value = cell.toString();
                        	value = cell;
                            System.out.println(i + "行" + j + " 列 is default type，" + value);
                    }// end switch  
                    colList.add(value);  
                }//end for j  
                rowList.add(colList);  
            }//end for i  
              
            
        }catch(Exception e){  
            System.out.println("exception");  
        }  
	}*/
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		 File file = new File("E:/test/产品参数2.xls");
		 String file_dir = "E:/test/产品参数2.xlsx";
		 Workbook book = null;
        book = getExcelWorkbook(file_dir);
        Sheet sheet = getSheetByNum(book,0);
        
        int lastRowNum = sheet.getLastRowNum();
        
        System.out.println("last number is "+ lastRowNum);
        
        for(int i = 1 ; i <= lastRowNum ; i++){
            Row row = null;
            row = sheet.getRow(i);
            if( row != null ){
                System.out.println("reading line is " + i);
                int lastCellNum = row.getLastCellNum();
                System.out.println("lastCellNum is " + lastCellNum );
                Cell cell = null;
                DecimalFormat df = new DecimalFormat("0.00"); 
                
                for( int j = 0 ; j <= lastCellNum ; j++ ){
                    cell = row.getCell(j);
                    
                    if( cell != null ){
                    	System.out.println("j-==" + j);
                    	System.out.println("cell.type==========" + cell.getCellType());
                    	if(j==3 || j==4){
//                    		cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                    		String cellValue = df.format(cell.getNumericCellValue());
//                    		double cellValue = cell.getNumericCellValue();
                    		System.out.println("净重：" + cellValue);
                    	}else{
                    		String cellValue = cell.getStringCellValue();
                            System.out.println("cell value is \n" + cellValue);
                    	}
                    }
                }
            }
        }
	}
	
	 public static Sheet getSheetByNum(Workbook book,int number){  
	        Sheet sheet = null;  
	        try {  
	            sheet = book.getSheetAt(number);  
//	          if(sheet == null){  
//	              sheet = book.createSheet("Sheet"+number);  
//	          }  
	        } catch (Exception e) {  
	            throw new RuntimeException(e.getMessage());  
	        }  
	        return sheet;  
	    }  
	    public static Workbook getExcelWorkbook(String filePath) throws IOException{  
	        Workbook book = null;  
	        File file  = null;  
	        FileInputStream fis = null;   
	          
	        try {  
	            file = new File(filePath);  
	            if(!file.exists()){  
	                throw new RuntimeException("文件不存在");  
	            }else{  
	                fis = new FileInputStream(file);  
	                book = WorkbookFactory.create(fis); 
	            }  
	        } catch (Exception e) {  
	            throw new RuntimeException(e.getMessage());  
	        } finally {  
	            if(fis != null){  
	                fis.close();  
	            }  
	        }  
	        return book;  
	    } 	
	
	
}
