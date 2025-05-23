package tencent.im.oidb.cmd0xe3b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe3b$HighlightTitle extends MessageMicro<oidb_0xe3b$HighlightTitle> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"bytes_highlight_title", "enum_title_type", "uint64_uin"}, new Object[]{ByteStringMicro.EMPTY, 0, 0L}, oidb_0xe3b$HighlightTitle.class);
    public final PBBytesField bytes_highlight_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_title_type = PBField.initEnum(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
}
