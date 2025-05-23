package tencent.im.oidb.cmd0xaef;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0xaef$SearchDocReq extends MessageMicro<Oidb_0xaef$SearchDocReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 48}, new String[]{"group_code", QCircleSchemeAttr.Detail.KEY_WORD, "start", "limit", "search_type", "file_type"}, new Object[]{0L, ByteStringMicro.EMPTY, 0, 0, 0, 0}, Oidb_0xaef$SearchDocReq.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBBytesField key_word = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field start = PBField.initUInt32(0);
    public final PBUInt32Field limit = PBField.initUInt32(0);
    public final PBUInt32Field search_type = PBField.initUInt32(0);
    public final PBUInt32Field file_type = PBField.initUInt32(0);
}
