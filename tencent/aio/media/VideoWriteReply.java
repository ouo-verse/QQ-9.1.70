package tencent.aio.media;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class VideoWriteReply extends MessageMicro<VideoWriteReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"result", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, WadlProxyConsts.KEY_JUMP_URL}, new Object[]{0, "", ""}, VideoWriteReply.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBStringField errmsg = PBField.initString("");
    public final PBStringField jumpUrl = PBField.initString("");
}
