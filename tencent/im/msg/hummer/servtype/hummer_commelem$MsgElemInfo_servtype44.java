package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import tencent.im.msg.im_msg_body$VideoFile;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hummer_commelem$MsgElemInfo_servtype44 extends MessageMicro<hummer_commelem$MsgElemInfo_servtype44> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_msg_data;
    public final PBBytesField bytes_text;
    public im_msg_body$VideoFile video_file;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"bytes_text", "video_file", "bytes_msg_data"}, new Object[]{byteStringMicro, null, byteStringMicro}, hummer_commelem$MsgElemInfo_servtype44.class);
    }

    public hummer_commelem$MsgElemInfo_servtype44() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_text = PBField.initBytes(byteStringMicro);
        this.video_file = new im_msg_body$VideoFile();
        this.bytes_msg_data = PBField.initBytes(byteStringMicro);
    }
}
