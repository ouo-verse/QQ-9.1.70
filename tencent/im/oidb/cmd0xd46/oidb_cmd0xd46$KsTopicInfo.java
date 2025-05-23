package tencent.im.oidb.cmd0xd46;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xd46$KsTopicInfo extends MessageMicro<oidb_cmd0xd46$KsTopicInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_icon_url;
    public final PBBytesField bytes_title;
    public final PBBytesField bytes_web_url;
    public final PBUInt32Field uint32_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_subscribe_ts;
    public final PBUInt32Field uint32_update_cnt;
    public final PBUInt32Field uint32_update_ts;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 88, 96, 104}, new String[]{"uint32_id", "bytes_title", "bytes_icon_url", "bytes_web_url", "uint32_subscribe_ts", "uint32_update_ts", "uint32_update_cnt"}, new Object[]{0, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, 0}, oidb_cmd0xd46$KsTopicInfo.class);
    }

    public oidb_cmd0xd46$KsTopicInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_title = PBField.initBytes(byteStringMicro);
        this.bytes_icon_url = PBField.initBytes(byteStringMicro);
        this.bytes_web_url = PBField.initBytes(byteStringMicro);
        this.uint32_subscribe_ts = PBField.initUInt32(0);
        this.uint32_update_ts = PBField.initUInt32(0);
        this.uint32_update_cnt = PBField.initUInt32(0);
    }
}
