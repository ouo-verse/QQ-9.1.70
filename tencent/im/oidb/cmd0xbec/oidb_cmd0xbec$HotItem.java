package tencent.im.oidb.cmd0xbec;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xbec$HotItem extends MessageMicro<oidb_cmd0xbec$HotItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_title"}, new Object[]{ByteStringMicro.EMPTY}, oidb_cmd0xbec$HotItem.class);
    public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
}
