package tencent.im.cs.cmd0x383;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.cs.cmd0x383.cmd0x383$ApplyGetFileListRspBody;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x383$ApplyFileSearchRspBody extends MessageMicro<cmd0x383$ApplyFileSearchRspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_key_word;
    public final PBBytesField bytes_sync_cookie;
    public final PBRepeatMessageField<Item> item_list;
    public final PBUInt32Field uint32_is_end;
    public final PBUInt32Field uint32_total_match_count;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class Item extends MessageMicro<Item> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_group_name;
        public final PBRepeatField<ByteStringMicro> bytes_match_word;
        public final PBBytesField bytes_uploader_nick_name;
        public cmd0x383$ApplyGetFileListRspBody.FileInfo file_info;
        public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
        public final PBUInt64Field uint64_match_uin;
        public final PBUInt64Field uint64_upload_uin;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 48, 58}, new String[]{"uint64_group_code", "bytes_group_name", "uint64_upload_uin", "bytes_uploader_nick_name", "bytes_match_word", "uint64_match_uin", "file_info"}, new Object[]{0L, byteStringMicro, 0L, byteStringMicro, byteStringMicro, 0L, null}, Item.class);
        }

        public Item() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_group_name = PBField.initBytes(byteStringMicro);
            this.uint64_upload_uin = PBField.initUInt64(0L);
            this.bytes_uploader_nick_name = PBField.initBytes(byteStringMicro);
            this.bytes_match_word = PBField.initRepeat(PBBytesField.__repeatHelper__);
            this.uint64_match_uin = PBField.initUInt64(0L);
            this.file_info = new cmd0x383$ApplyGetFileListRspBody.FileInfo();
        }
    }

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40}, new String[]{"bytes_sync_cookie", "uint32_is_end", "bytes_key_word", "item_list", "uint32_total_match_count"}, new Object[]{byteStringMicro, 0, byteStringMicro, null, 0}, cmd0x383$ApplyFileSearchRspBody.class);
    }

    public cmd0x383$ApplyFileSearchRspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_sync_cookie = PBField.initBytes(byteStringMicro);
        this.uint32_is_end = PBField.initUInt32(0);
        this.bytes_key_word = PBField.initBytes(byteStringMicro);
        this.item_list = PBField.initRepeatMessage(Item.class);
        this.uint32_total_match_count = PBField.initUInt32(0);
    }
}
