package tencent.im.s2c.msgtype0x210.submsgtype0x93;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x93$LiteMailIndexInfo extends MessageMicro<submsgtype0x93$LiteMailIndexInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_feeds_id", "msg_source_id"}, new Object[]{ByteStringMicro.EMPTY, null}, submsgtype0x93$LiteMailIndexInfo.class);
    public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public submsgtype0x93$SourceID msg_source_id = new submsgtype0x93$SourceID();
}
