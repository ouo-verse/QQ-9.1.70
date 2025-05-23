package tencent.im.cs.cmd0x383;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x383$ApplyFileSearchReqBody extends MessageMicro<cmd0x383$ApplyFileSearchReqBody> {
    public static final int AUDIO = 3;
    public static final int DOCUMENT = 1;
    public static final int OTHER = 10000;
    public static final int PICTURE = 4;
    public static final int SEARCH_BY_FILE_TYPE = 2;
    public static final int SEARCH_BY_KEY_WORD = 0;
    public static final int SEARCH_BY_KEY_WORD_AND_VIDEO = 3;
    public static final int VIDEO = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_key_word;
    public final PBBytesField bytes_sync_cookie;
    public final PBUInt32Field uint32_count;
    public final PBUInt32Field uint32_file_type;
    public final PBUInt32Field uint32_search_type;
    public final PBRepeatField<Long> uint64_group_code_list;
    public final PBRepeatField<Long> uint64_uin_list;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 80, 88}, new String[]{"uint64_group_code_list", "uint64_uin_list", "bytes_key_word", "bytes_sync_cookie", "uint32_count", "uint32_search_type", "uint32_file_type"}, new Object[]{0L, 0L, byteStringMicro, byteStringMicro, 0, 0, 0}, cmd0x383$ApplyFileSearchReqBody.class);
    }

    public cmd0x383$ApplyFileSearchReqBody() {
        PBUInt64Field pBUInt64Field = PBUInt64Field.__repeatHelper__;
        this.uint64_group_code_list = PBField.initRepeat(pBUInt64Field);
        this.uint64_uin_list = PBField.initRepeat(pBUInt64Field);
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_key_word = PBField.initBytes(byteStringMicro);
        this.bytes_sync_cookie = PBField.initBytes(byteStringMicro);
        this.uint32_count = PBField.initUInt32(0);
        this.uint32_search_type = PBField.initUInt32(0);
        this.uint32_file_type = PBField.initUInt32(0);
    }
}
