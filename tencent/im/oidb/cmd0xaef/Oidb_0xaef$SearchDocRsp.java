package tencent.im.oidb.cmd0xaef;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0xaef$SearchDocRsp extends MessageMicro<Oidb_0xaef$SearchDocRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42}, new String[]{"next", "is_end", QCircleSchemeAttr.Detail.KEY_WORD, "match_count", "doc_list"}, new Object[]{0, 0, ByteStringMicro.EMPTY, 0, null}, Oidb_0xaef$SearchDocRsp.class);
    public final PBUInt32Field next = PBField.initUInt32(0);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBBytesField key_word = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field match_count = PBField.initUInt32(0);
    public final PBRepeatMessageField<Oidb_0xaef$SearchItem> doc_list = PBField.initRepeatMessage(Oidb_0xaef$SearchItem.class);
}
