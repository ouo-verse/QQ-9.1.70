package tencent.qun.group_effect;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class group_effect_commu$TEffectDetail extends MessageMicro<group_effect_commu$TEffectDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"st_userconfig", "st_effectinfo"}, new Object[]{null, null}, group_effect_commu$TEffectDetail.class);
    public group_effect$UserConfig st_userconfig = new group_effect$UserConfig();
    public group_effect$EffectInfo st_effectinfo = new group_effect$EffectInfo();
}
