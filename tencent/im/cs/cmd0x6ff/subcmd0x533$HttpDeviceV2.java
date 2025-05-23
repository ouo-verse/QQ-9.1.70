package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class subcmd0x533$HttpDeviceV2 extends MessageMicro<subcmd0x533$HttpDeviceV2> {
    public static final int Android = 1;
    public static final int IOS = 0;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"platform"}, new Object[]{0}, subcmd0x533$HttpDeviceV2.class);
    public final PBEnumField platform = PBField.initEnum(0);
}
