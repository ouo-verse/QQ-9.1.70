package tencent.im.qqwallet;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QWalletPubAdReport$QueryReq extends MessageMicro<QWalletPubAdReport$QueryReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"uin", "pskey", WadlProxyConsts.CHANNEL, "terminal_infor"}, new Object[]{"", "", 0, null}, QWalletPubAdReport$QueryReq.class);
    public final PBStringField uin = PBField.initString("");
    public final PBStringField pskey = PBField.initString("");
    public final PBInt32Field channel = PBField.initInt32(0);
    public QWalletPubAdReport$TerminalInfor terminal_infor = new QWalletPubAdReport$TerminalInfor();
}
