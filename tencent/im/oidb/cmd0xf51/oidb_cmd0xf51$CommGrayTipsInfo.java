package tencent.im.oidb.cmd0xf51;

import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xf51$CommGrayTipsInfo extends MessageMicro<oidb_cmd0xf51$CommGrayTipsInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{MessageForUniteGrayTip.KEY_UINT64_BUSI_ID, MessageForUniteGrayTip.KEY_UINT64_TIPS_SEQ_ID}, new Object[]{0L, 0L}, oidb_cmd0xf51$CommGrayTipsInfo.class);
    public final PBUInt64Field uint64_busi_id = PBField.initUInt64(0);
    public final PBUInt64Field uint64_tips_seq_id = PBField.initUInt64(0);
}
