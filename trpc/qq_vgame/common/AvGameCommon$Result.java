package trpc.qq_vgame.common;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameCommon$Result extends MessageMicro<AvGameCommon$Result> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"errcode", HippyReporter.EXTRA_KEY_REPORT_ERRMSG}, new Object[]{0, ByteStringMicro.EMPTY}, AvGameCommon$Result.class);
    public final PBUInt32Field errcode = PBField.initUInt32(0);
    public final PBBytesField errmsg = PBField.initBytes(ByteStringMicro.EMPTY);
}
