package tencent.im.oidb.cmd0xb85;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0xb85$RspBody extends MessageMicro<Oidb_0xb85$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{90, 98}, new String[]{"report_score_rsp", "get_ranklist_rsp"}, new Object[]{null, null}, Oidb_0xb85$RspBody.class);
    public Oidb_0xb85$ReportScoreRspBody report_score_rsp = new MessageMicro<Oidb_0xb85$ReportScoreRspBody>() { // from class: tencent.im.oidb.cmd0xb85.Oidb_0xb85$ReportScoreRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], Oidb_0xb85$ReportScoreRspBody.class);
    };
    public Oidb_0xb85$GetRankListRspBody get_ranklist_rsp = new Oidb_0xb85$GetRankListRspBody();
}
