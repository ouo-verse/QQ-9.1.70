package wns_proxy;

import com.tencent.view.FilterEnum;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import org.jf.dexlib2.analysis.RegisterType;

/* loaded from: classes30.dex */
public class GZIP {
    private static final int BTYPE_DYNAMIC = 2;
    private static final int BTYPE_FIXED = 1;
    private static final int BTYPE_NONE = 0;
    private static final int BTYPE_RESERVED = 3;
    private static final int EOB_CODE = 256;
    private static final int FCOMMENT_MASK = 16;
    private static final int FEXTRA_MASK = 4;
    private static final int FHCRC_MASK = 2;
    private static final int FNAME_MASK = 8;
    private static final int FTEXT_MASK = 1;
    private static final int MAX_BITS = 16;
    private static final int MAX_CODE_DISTANCES = 31;
    private static final int MAX_CODE_LENGTHS = 18;
    private static final int MAX_CODE_LITERALS = 287;
    private static byte[] buffer;
    private static int buffer_bit;
    private static int buffer_byte;
    private static int buffer_index;
    private static byte[] distance_extra_bits;
    private static short[] distance_values;
    private static byte[] dynamic_length_order;
    private static byte[] length_extra_bits;
    private static short[] length_values;
    private static byte[] uncompressed;
    private static int uncompressed_index;

    private static int[] createHuffmanTree(byte[] bArr, int i3) {
        int i16;
        int[] iArr = new int[17];
        for (byte b16 : bArr) {
            iArr[b16] = iArr[b16] + 1;
        }
        iArr[0] = 0;
        int[] iArr2 = new int[17];
        int i17 = 0;
        for (int i18 = 1; i18 <= 16; i18++) {
            i17 = (i17 + iArr[i18 - 1]) << 1;
            iArr2[i18] = i17;
        }
        int[] iArr3 = new int[(i3 << 1) + 16];
        int i19 = 1;
        for (int i26 = 0; i26 <= i3; i26++) {
            byte b17 = bArr[i26];
            if (b17 != 0) {
                int i27 = iArr2[b17];
                iArr2[b17] = i27 + 1;
                int i28 = 0;
                for (int i29 = b17 - 1; i29 >= 0; i29--) {
                    if (((1 << i29) & i27) == 0) {
                        int i36 = iArr3[i28];
                        i16 = i36 >> 16;
                        if (i16 == 0) {
                            iArr3[i28] = i36 | (i19 << 16);
                            i16 = i19;
                            i19++;
                        }
                    } else {
                        int i37 = iArr3[i28];
                        i16 = 65535 & i37;
                        if (i16 == 0) {
                            iArr3[i28] = i37 | i19;
                            i28 = i19;
                            i19++;
                        }
                    }
                    i28 = i16;
                }
                iArr3[i28] = Integer.MIN_VALUE | i26;
            }
        }
        return iArr3;
    }

    private static byte[] decodeCodeLengths(int[] iArr, int i3) {
        int readBits;
        int i16;
        byte[] bArr = new byte[i3];
        int i17 = 0;
        int i18 = 0;
        while (i17 < i3) {
            int readCode = readCode(iArr);
            if (readCode >= 16) {
                if (readCode == 16) {
                    i16 = readBits(2) + 3;
                } else {
                    if (readCode == 17) {
                        readBits = readBits(3) + 3;
                    } else {
                        readBits = readBits(7) + 11;
                    }
                    i16 = readBits;
                    i18 = 0;
                }
                while (true) {
                    int i19 = i16 - 1;
                    if (i16 > 0) {
                        bArr[i17] = (byte) i18;
                        i17++;
                        i16 = i19;
                    }
                }
            } else {
                if (readCode != 0) {
                    bArr[i17] = (byte) readCode;
                    i17++;
                } else {
                    i17++;
                }
                i18 = readCode;
            }
        }
        return bArr;
    }

    public static byte[] inflate(byte[] bArr) throws IOException {
        return inflate(bArr, 0);
    }

    private static void inflateBlock(int[] iArr, int[] iArr2) {
        while (true) {
            int readCode = readCode(iArr);
            if (readCode != 256) {
                if (readCode > 256) {
                    int i3 = readCode - 257;
                    short s16 = length_values[i3];
                    byte b16 = length_extra_bits[i3];
                    int i16 = s16;
                    if (b16 > 0) {
                        i16 = s16 + readBits(b16);
                    }
                    int readCode2 = readCode(iArr2);
                    short s17 = distance_values[readCode2];
                    byte b17 = distance_extra_bits[readCode2];
                    int i17 = s17;
                    if (b17 > 0) {
                        i17 = s17 + readBits(b17);
                    }
                    int i18 = uncompressed_index - i17;
                    for (int i19 = 0; i19 < i16; i19++) {
                        byte[] bArr = uncompressed;
                        int i26 = uncompressed_index;
                        uncompressed_index = i26 + 1;
                        bArr[i26] = bArr[i18 + i19];
                    }
                } else {
                    byte[] bArr2 = uncompressed;
                    int i27 = uncompressed_index;
                    uncompressed_index = i27 + 1;
                    bArr2[i27] = (byte) readCode;
                }
            } else {
                return;
            }
        }
    }

    private static void inflateDynamic() {
        int readBits = readBits(5) + 257;
        int readBits2 = readBits(5) + 1;
        int readBits3 = readBits(4) + 4;
        byte[] bArr = new byte[19];
        for (int i3 = 0; i3 < readBits3; i3++) {
            bArr[dynamic_length_order[i3]] = (byte) readBits(3);
        }
        int[] createHuffmanTree = createHuffmanTree(bArr, 18);
        inflateBlock(createHuffmanTree(decodeCodeLengths(createHuffmanTree, readBits), readBits - 1), createHuffmanTree(decodeCodeLengths(createHuffmanTree, readBits2), readBits2 - 1));
    }

    private static void inflateFixed() {
        int i3;
        int i16;
        int i17;
        byte[] bArr = new byte[288];
        int i18 = 0;
        while (true) {
            i3 = 144;
            if (i18 >= 144) {
                break;
            }
            bArr[i18] = 8;
            i18++;
        }
        while (true) {
            i16 = 256;
            if (i3 >= 256) {
                break;
            }
            bArr[i3] = 9;
            i3++;
        }
        while (true) {
            if (i16 >= 280) {
                break;
            }
            bArr[i16] = 7;
            i16++;
        }
        for (i17 = FilterEnum.MIC_PTU_TRANS_XINXIAN; i17 < 288; i17++) {
            bArr[i17] = 8;
        }
        int[] createHuffmanTree = createHuffmanTree(bArr, 287);
        byte[] bArr2 = new byte[32];
        for (int i19 = 0; i19 < 32; i19++) {
            bArr2[i19] = 5;
        }
        inflateBlock(createHuffmanTree, createHuffmanTree(bArr2, 31));
    }

    private static void inflateStored() {
        buffer_bit = 0;
        int readBits = readBits(16);
        readBits(16);
        System.arraycopy(buffer, buffer_index, uncompressed, uncompressed_index, readBits);
        buffer_index += readBits;
        uncompressed_index += readBits;
    }

    public static byte[] inflateSyn(byte[] bArr, int i3) throws IOException {
        return inflate(bArr, i3);
    }

    public static DataInputStream openDataInputStream(byte[] bArr) throws IOException {
        return new DataInputStream(new ByteArrayInputStream(inflate(bArr)));
    }

    private static int readBits(int i3) {
        int i16;
        int i17 = buffer_bit;
        if (i17 == 0) {
            byte[] bArr = buffer;
            int i18 = buffer_index;
            buffer_index = i18 + 1;
            i16 = bArr[i18] & 255;
            buffer_byte = i16;
        } else {
            i16 = buffer_byte >> i17;
        }
        for (int i19 = 8 - i17; i19 < i3; i19 += 8) {
            byte[] bArr2 = buffer;
            int i26 = buffer_index;
            buffer_index = i26 + 1;
            int i27 = bArr2[i26] & 255;
            buffer_byte = i27;
            i16 |= i27 << i19;
        }
        buffer_bit = (buffer_bit + i3) & 7;
        return ((1 << i3) - 1) & i16;
    }

    private static int readCode(int[] iArr) {
        int i3 = iArr[0];
        while (i3 >= 0) {
            int i16 = buffer_bit;
            if (i16 == 0) {
                byte[] bArr = buffer;
                int i17 = buffer_index;
                buffer_index = i17 + 1;
                buffer_byte = bArr[i17] & 255;
            }
            if ((buffer_byte & (1 << i16)) == 0) {
                i3 = iArr[i3 >> 16];
            } else {
                i3 = iArr[i3 & 65535];
            }
            buffer_bit = (i16 + 1) & 7;
        }
        return i3 & 65535;
    }

    private static synchronized byte[] inflate(byte[] bArr, int i3) throws IOException {
        int readBits;
        byte[] bArr2;
        synchronized (GZIP.class) {
            try {
                buffer = bArr;
                buffer_index += i3;
                if (readBits(16) == 35615 && readBits(8) == 8) {
                    int readBits2 = readBits(8);
                    int i16 = buffer_index + 6;
                    buffer_index = i16;
                    if ((readBits2 & 4) != 0) {
                        buffer_index = i16 + readBits(16);
                    }
                    while ((readBits2 & 8) != 0) {
                        byte[] bArr3 = buffer;
                        int i17 = buffer_index;
                        buffer_index = i17 + 1;
                        if (bArr3[i17] == 0) {
                            break;
                        }
                    }
                    while ((readBits2 & 16) != 0) {
                        byte[] bArr4 = buffer;
                        int i18 = buffer_index;
                        buffer_index = i18 + 1;
                        if (bArr4[i18] == 0) {
                            break;
                        }
                    }
                    if ((readBits2 & 2) != 0) {
                        buffer_index += 2;
                    }
                    int i19 = buffer_index;
                    buffer_index = buffer.length - 4;
                    uncompressed = new byte[readBits(16) | (readBits(16) << 16)];
                    buffer_index = i19;
                    length_extra_bits = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 0, 99, 99};
                    length_values = new short[]{3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 15, 17, 19, 23, 27, 31, 35, 43, 51, 59, 67, 83, 99, 115, 131, 163, 195, 227, 258, 0, 0};
                    distance_extra_bits = new byte[]{0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12, 12, 13, 13};
                    distance_values = new short[]{1, 2, 3, 4, 5, 7, 9, 13, 17, 25, 33, 49, 65, 97, 129, 193, 257, 385, 513, 769, 1025, 1537, 2049, 3073, 4097, 6145, 8193, 12289, 16385, 24577};
                    dynamic_length_order = new byte[]{RegisterType.UNINIT_REF, 17, RegisterType.REFERENCE, 0, 8, 7, 9, 6, 10, 5, 11, 4, 12, 3, 13, 2, RegisterType.DOUBLE_LO, 1, RegisterType.DOUBLE_HI};
                    do {
                        readBits = readBits(1);
                        int readBits3 = readBits(2);
                        if (readBits3 == 0) {
                            inflateStored();
                        } else if (readBits3 == 1) {
                            inflateFixed();
                        } else if (readBits3 == 2) {
                            inflateDynamic();
                        } else {
                            throw new IOException("Invalid GZIP block");
                        }
                    } while (readBits == 0);
                    bArr2 = uncompressed;
                } else {
                    throw new IOException("Invalid GZIP format");
                }
            } finally {
                uncompressed_index = 0;
                buffer_bit = 0;
                buffer_byte = 0;
                buffer_index = 0;
                byte[] bArr5 = null;
                dynamic_length_order = bArr5;
                distance_extra_bits = bArr5;
                length_extra_bits = bArr5;
                uncompressed = bArr5;
                buffer = bArr5;
                short[] sArr = null;
                distance_values = sArr;
                length_values = sArr;
            }
        }
        return bArr2;
    }
}
