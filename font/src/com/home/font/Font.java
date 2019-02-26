package com.home.font;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Font {
	/* the values in this array are a 8x8 bitmap font for ascii characters */
    static long[] fontInfo = {
        0x7E7E7E7E7E7E0000L,	/* NUL */
        0x7E7E7E7E7E7E0000L,	/* SOH */
        0x7E7E7E7E7E7E0000L,	/* STX */
        0x7E7E7E7E7E7E0000L,	/* ETX */
        0x7E7E7E7E7E7E0000L,	/* EOT */
        0x7E7E7E7E7E7E0000L,	/* ENQ */
        0x7E7E7E7E7E7E0000L,	/* ACK */
        0x7E7E7E7E7E7E0000L,	/* BEL */
        0x7E7E7E7E7E7E0000L,	/* BS */
        0x0L,					/* TAB */
        0x7E7E7E7E7E7E0000L,	/* LF */
        0x7E7E7E7E7E7E0000L,	/* VT */
        0x7E7E7E7E7E7E0000L,	/* FF */
        0x7E7E7E7E7E7E0000L,	/* CR */
        0x7E7E7E7E7E7E0000L,	/* SO */
        0x7E7E7E7E7E7E0000L,	/* SI */
        0x7E7E7E7E7E7E0000L,	/* DLE */
        0x7E7E7E7E7E7E0000L,	/* DC1 */
        0x7E7E7E7E7E7E0000L,	/* DC2 */
        0x7E7E7E7E7E7E0000L,	/* DC3 */
        0x7E7E7E7E7E7E0000L,	/* DC4 */
        0x7E7E7E7E7E7E0000L,	/* NAK */
        0x7E7E7E7E7E7E0000L,	/* SYN */
        0x7E7E7E7E7E7E0000L,	/* ETB */
        0x7E7E7E7E7E7E0000L,	/* CAN */
        0x7E7E7E7E7E7E0000L,	/* EM */
        0x7E7E7E7E7E7E0000L,	/* SUB */
        0x7E7E7E7E7E7E0000L,	/* ESC */
        0x7E7E7E7E7E7E0000L,	/* FS */
        0x7E7E7E7E7E7E0000L,	/* GS */
        0x7E7E7E7E7E7E0000L,	/* RS */
        0x7E7E7E7E7E7E0000L,	/* US */
        0x0L,					/* (space) */
        0x808080800080000L,		/* ! */
        0x2828000000000000L,	/* " */
        0x287C287C280000L,		/* # */
        0x81E281C0A3C0800L,		/* $ */
        0x6094681629060000L,	/* % */
        0x1C20201926190000L,	/* & */
        0x808000000000000L,		/* ' */
        0x810202010080000L,		/* ( */
        0x1008040408100000L,	/* ) */
        0x2A1C3E1C2A000000L,	/* * */
        0x8083E08080000L,		/* + */
        0x81000L,				/* L, */
        0x3C00000000L,			/* - */
        0x80000L,				/* . */
        0x204081020400000L,		/* / */
        0x1824424224180000L,	/* 0 */
        0x8180808081C0000L,		/* 1 */
        0x3C420418207E0000L,	/* 2 */
        0x3C420418423C0000L,	/* 3 */
        0x81828487C080000L,		/* 4 */
        0x7E407C02423C0000L,	/* 5 */
        0x3C407C42423C0000L,	/* 6 */
        0x7E04081020400000L,	/* 7 */
        0x3C423C42423C0000L,	/* 8 */
        0x3C42423E023C0000L,	/* 9 */
        0x80000080000L,			/* : */
        0x80000081000L,			/* ; */
        0x6186018060000L,		/* < */
        0x7E007E000000L,		/* = */
        0x60180618600000L,		/* > */
        0x3844041800100000L,	/* ? */
        0x3C449C945C201CL,		/* @ */
        0x1818243C42420000L,	/* A */
        0x7844784444780000L,	/* B */
        0x3844808044380000L,	/* C */
        0x7844444444780000L,	/* D */
        0x7C407840407C0000L,	/* E */
        0x7C40784040400000L,	/* F */
        0x3844809C44380000L,	/* G */
        0x42427E4242420000L,	/* H */
        0x3E080808083E0000L,	/* I */
        0x1C04040444380000L,	/* J */
        0x4448507048440000L,	/* K */
        0x40404040407E0000L,	/* L */
        0x4163554941410000L,	/* M */
        0x4262524A46420000L,	/* N */
        0x1C222222221C0000L,	/* O */
        0x7844784040400000L,	/* P */
        0x1C222222221C0200L,	/* Q */
        0x7844785048440000L,	/* R */
        0x1C22100C221C0000L,	/* S */
        0x7F08080808080000L,	/* T */
        0x42424242423C0000L,	/* U */
        0x8142422424180000L,	/* V */
        0x4141495563410000L,	/* W */
        0x4224181824420000L,	/* X */
        0x4122140808080000L,	/* Y */
        0x7E040810207E0000L,	/* Z */
        0x3820202020380000L,	/* [ */
        0x4020100804020000L,	/* \ */
        0x3808080808380000L,	/* ] */
        0x1028000000000000L,	/* ^ */
        0x7E0000L,				/* _ */
        0x1008000000000000L,	/* ` */
        0x3C023E463A0000L,		/* a */
        0x40407C42625C0000L,	/* b */
        0x1C20201C0000L,		/* c */
        0x2023E42463A0000L,		/* d */
        0x3C427E403C0000L,		/* e */
        0x18103810100000L,		/* f */
        0x344C44340438L,		/* g */
        0x2020382424240000L,	/* h */
        0x800080808080000L,		/* i */
        0x800180808080870L,		/* j */
        0x20202428302C0000L,	/* k */
        0x1010101010180000L,	/* l */
        0x665A42420000L,		/* m */
        0x2E3222220000L,		/* n */
        0x3C42423C0000L,		/* o */
        0x5C62427C4040L,		/* p */
        0x3A46423E0202L,		/* q */
        0x2C3220200000L,		/* r */
        0x1C201804380000L,		/* s */
        0x103C1010180000L,		/* t */
        0x2222261A0000L,		/* u */
        0x424224180000L,		/* v */
        0x81815A660000L,		/* w */
        0x422418660000L,		/* x */
        0x422214081060L,		/* y */
        0x3C08103C0000L,		/* z */
        0x1C103030101C0000L,	/* { */
        0x808080808080800L,		/* | */
        0x38080C0C08380000L,	/* } */
        0x324C000000L,			/* ~ */
        0x7E7E7E7E7E7E0000L		/* DEL */
    };
    
    static final int W = 45;
    static final int H = 8;
    static final int fontSize = 8;
	public static void main(String[] args) {
		byte[][] LEDBoard = new byte[H][W];
		String [] inputData = {"ABC","3sec"};  
		LEDBoard = FillWithFont(inputData[0]);
		DisplayLED(LEDBoard);
		
		for (int i=0; i<H; i++)
			for (int j=0; j<W; j++)
				LEDBoard[i][j] = 0;
		
		LEDBoard = FillWithFontAfterTime(inputData[0], inputData[1]);
		DisplayLED(LEDBoard);
	}
	
	static void fill(byte[][] result, String inputStr)
	{
		for (int i=0; i<inputStr.length(); i++)
		{
			long fi = fontInfo[inputStr.charAt(i)];
			String hexStr = String.format("%016X", fi);
			
			for (int h=0; h<H; h++)
			{
				String sub = hexStr.substring(h*2,  h*2+2);
				String binStr = Integer.toBinaryString(Integer.parseInt(sub, 16));
				for (int b=fontSize - binStr.length(); b>0; b-- )
				{
					binStr = "0" + binStr;
				}
				
				for (int b=0; b<fontSize; b++)
				{
					if (binStr.charAt(b) == '0')
						result[h][i*(fontSize+1)+b] = 0;
					else 
						result[h][i*(fontSize+1)+b] = 1;
				}
			}
		}
	}
	
	
	static byte[][] FillWithFont(String inputStr)
	{
		byte[][] result = new byte[H][W];
		//////////////////////////////////////
		
		fill(result, inputStr);
		
		//////////////////////////////////////
		return result;
	}
	
	static byte[][] FillWithFontAfterTime(String inputStr, String inputSec)
	{
		byte[][] result = new byte[H][W];
		//////////////////////////////////////
		byte[][] temp = new byte[H][W];
		fill(temp, inputStr);
		
		int sec = Integer.parseInt(inputSec.replace("sec", ""));
		for (int i=0; i<H; i++)
		{
			for (int j=sec; j<sec+W; j++)
			{
				result[i][j-sec] = temp[i][j%W];
			}
		}
		//////////////////////////////////////
		return result;
	}
	
	static void DisplayLED(byte[][] board)
	{
		for (int i=0; i<H; i++)
		{
			for (int j=0; j<W; j++)
			{
				if (board[i][j] == 0)
					System.out.print('.');
				else 
					System.out.print('*');
			}
			System.out.println();
		}
		System.out.println();
	}
}
