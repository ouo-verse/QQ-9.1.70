package tencent.im.oidb.cmd0xbe0;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xbe0$ReqBody extends MessageMicro<cmd0xbe0$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_context;
    public final PBBytesField bytes_imsi;
    public final PBBytesField bytes_req_advertise_para;
    public final PBBytesField bytes_version;
    public final PBUInt32Field comic_id;
    public final PBUInt32Field uint32_current_index;
    public final PBUInt32Field uint32_data_page_index;
    public final PBUInt32Field uint32_data_page_num;
    public final PBUInt32Field uint32_is_wifi;
    public final PBUInt32Field uint32_need_attch_comments;
    public final PBUInt32Field uint32_need_social_info;
    public final PBUInt32Field uint32_next_req_size;
    public final PBUInt32Field uint32_os;
    public final PBUInt32Field uint32_source;
    public final PBUInt32Field uint32_style;
    public final PBUInt32Field uint32_more_gallery = PBField.initUInt32(0);
    public final PBUInt32Field uint32_next_gallery = PBField.initUInt32(0);
    public cmd0xbe0$StackInfo msg_stack_info = new MessageMicro<cmd0xbe0$StackInfo>() { // from class: tencent.im.oidb.cmd0xbe0.cmd0xbe0$StackInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"rpt_msg_stack_gallery", "bytes_current_gallery_rowkey"}, new Object[]{null, ByteStringMicro.EMPTY}, cmd0xbe0$StackInfo.class);
        public final PBRepeatMessageField<cmd0xbe0$StackGallery> rpt_msg_stack_gallery = PBField.initRepeatMessage(cmd0xbe0$StackGallery.class);
        public final PBBytesField bytes_current_gallery_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public cmd0xbe0$UserInfo msg_user_info = new MessageMicro<cmd0xbe0$UserInfo>() { // from class: tencent.im.oidb.cmd0xbe0.cmd0xbe0$UserInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"bytes_user_bir", "uint32_user_sex", "bytes_user_city"}, new Object[]{0, 0, ByteStringMicro.EMPTY}, cmd0xbe0$UserInfo.class);
        public final PBUInt32Field bytes_user_bir = PBField.initUInt32(0);
        public final PBUInt32Field uint32_user_sex = PBField.initUInt32(0);
        public final PBBytesField bytes_user_city = PBField.initBytes(ByteStringMicro.EMPTY);
    };

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 48, 58, 64, 72, 80, 88, 96, 104, 112, 122, 130, 800, 808, 816}, new String[]{"uint32_more_gallery", "uint32_next_gallery", "msg_stack_info", "msg_user_info", "bytes_version", "uint32_os", "bytes_imsi", "uint32_is_wifi", "uint32_next_req_size", "uint32_need_social_info", "uint32_need_attch_comments", "uint32_current_index", "uint32_source", "uint32_style", "bytes_context", "bytes_req_advertise_para", "comic_id", "uint32_data_page_num", "uint32_data_page_index"}, new Object[]{0, 0, null, null, byteStringMicro, 0, byteStringMicro, 0, 0, 0, 0, 0, 0, 0, byteStringMicro, byteStringMicro, 0, 0, 0}, cmd0xbe0$ReqBody.class);
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [tencent.im.oidb.cmd0xbe0.cmd0xbe0$StackInfo] */
    /* JADX WARN: Type inference failed for: r1v3, types: [tencent.im.oidb.cmd0xbe0.cmd0xbe0$UserInfo] */
    public cmd0xbe0$ReqBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_version = PBField.initBytes(byteStringMicro);
        this.uint32_os = PBField.initUInt32(0);
        this.bytes_imsi = PBField.initBytes(byteStringMicro);
        this.uint32_is_wifi = PBField.initUInt32(0);
        this.uint32_next_req_size = PBField.initUInt32(0);
        this.uint32_need_social_info = PBField.initUInt32(0);
        this.uint32_need_attch_comments = PBField.initUInt32(0);
        this.uint32_current_index = PBField.initUInt32(0);
        this.uint32_source = PBField.initUInt32(0);
        this.uint32_style = PBField.initUInt32(0);
        this.bytes_context = PBField.initBytes(byteStringMicro);
        this.bytes_req_advertise_para = PBField.initBytes(byteStringMicro);
        this.comic_id = PBField.initUInt32(0);
        this.uint32_data_page_num = PBField.initUInt32(0);
        this.uint32_data_page_index = PBField.initUInt32(0);
    }
}
