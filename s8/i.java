package s8;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.luggage.wxa.lj.q;
import com.tencent.luggage.wxa.xd.c0;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.mini.api.LaunchScene;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.qzoneplayer.video.FeedResources;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.soter.core.biometric.FaceManager;
import cooperation.qzone.report.lp.LpReportInfoConfig;

/* compiled from: P */
/* loaded from: classes36.dex */
public class i implements FeedResources {
    @Override // com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources
    public int getAnimationId(int i3) {
        return 0;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources
    public Drawable getDrawable(int i3) {
        try {
            return PlayerConfig.g().getAppContext().getResources().getDrawable(getDrawableId(i3));
        } catch (Exception unused) {
            return new ColorDrawable(0);
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources
    public int getDrawableId(int i3) {
        switch (i3) {
            case 1101:
                return R.drawable.gar;
            case 1102:
                return R.drawable.gaq;
            case 1103:
                return R.drawable.f162304gc3;
            case 1104:
            case 1105:
            case 1107:
            case 1112:
            case 1113:
            case 1118:
            case FaceManager.FACE_ACQUIRED_MULTI_FACE /* 1121 */:
            case IWeiyunResponseHandler.ERROR_DISK_SERVER_CODE_FLOW_LIMIT /* 1127 */:
            case 1128:
            case 1129:
            case 1132:
            default:
                return 0;
            case 1106:
                return R.drawable.gc9;
            case 1108:
            case 1114:
                return R.drawable.gia;
            case 1109:
                return R.drawable.ghl;
            case 1110:
                return R.drawable.fu8;
            case 1111:
                return R.drawable.fua;
            case 1115:
                return R.drawable.f162363gi1;
            case 1116:
                return R.drawable.f162362gi0;
            case 1117:
                return R.drawable.g3u;
            case 1119:
                return R.drawable.gho;
            case 1120:
            case BusinessInfoCheckUpdateItem.UIAPPID_KANDIAN /* 1130 */:
                return R.drawable.gin;
            case 1122:
                return R.drawable.gib;
            case AppConstants.RiskHintTemplate.TEMPLATE_TYPE_RISK_FOR_PROTECT /* 1123 */:
                return R.drawable.f162303gc2;
            case 1124:
                return R.drawable.gcl;
            case gdt_analysis_event.EVENT_GET_USER_AGENT /* 1125 */:
                return R.drawable.gcm;
            case 1126:
                return R.drawable.gcn;
            case 1131:
                return R.drawable.giu;
            case LaunchScene.LAUNCH_SCENE_VM_NOTIFICATION /* 1133 */:
                return R.drawable.ghq;
            case 1134:
                return R.drawable.fub;
            case 1135:
                return R.drawable.fu9;
            case 1136:
                return R.drawable.gc5;
            case 1137:
                return R.drawable.gc6;
            case com.tencent.luggage.wxa.ef.h.CTRL_INDEX /* 1138 */:
                return R.drawable.g3y;
            case 1139:
                return R.drawable.g3x;
            case 1140:
                return R.drawable.ghx;
            case com.tencent.luggage.wxa.yh.b.CTRL_INDEX /* 1141 */:
                return R.drawable.ghy;
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources
    public int getInteger(int i3) {
        return 0;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources
    public int getLayoutId(int i3) {
        switch (i3) {
            case 9:
                return R.layout.bph;
            case 10:
                return R.layout.bpi;
            case 11:
                return R.layout.bpj;
            case 12:
                return R.layout.bpg;
            case 13:
                return R.layout.bpp;
            case 14:
                return R.layout.bpo;
            case 15:
                return R.layout.bpb;
            case 16:
                return R.layout.bhc;
            case 17:
                return R.layout.bsm;
            case 18:
                return R.layout.bp_;
            case 19:
                return R.layout.bpa;
            case 20:
                return R.layout.bpn;
            case 21:
                return R.layout.bsx;
            case 22:
                return R.layout.bsp;
            case 23:
                return R.layout.bsl;
            default:
                return 0;
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources
    public int getRawId(int i3) {
        return 0;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources
    public CharSequence getText(int i3) {
        return null;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources
    public int getViewId(int i3) {
        if (i3 != 29) {
            switch (i3) {
                case PlayerResources.ViewId.OPEN_FREE_TRAFFIC_CONTAINER /* 581 */:
                    return R.id.ho6;
                case 582:
                    return R.id.ho7;
                case 583:
                    return R.id.ho8;
                case 584:
                    return R.id.c8b;
                default:
                    switch (i3) {
                        case 586:
                            return R.id.ho_;
                        case LpReportInfoConfig.ACTION_HOMEPAGE_GUEST /* 587 */:
                            return R.id.hnu;
                        case 588:
                            return R.id.hnn;
                        case com.tencent.luggage.wxa.c3.f.CTRL_INDEX /* 589 */:
                            return R.id.ho5;
                        case c0.CTRL_INDEX /* 590 */:
                            return R.id.hnw;
                        case 591:
                            return R.id.ho9;
                        case com.tencent.luggage.wxa.v6.d.CTRL_INDEX /* 592 */:
                            return R.id.hoi;
                        case LpReportInfoConfig.ACTION_TYPE_COMMON_SETTING /* 593 */:
                            return R.id.hop;
                        case 594:
                            return R.id.hol;
                        default:
                            switch (i3) {
                                case 596:
                                    return R.id.hoq;
                                case 597:
                                    return R.id.hor;
                                case 598:
                                    return R.id.hos;
                                case 599:
                                    return R.id.hot;
                                case 600:
                                    return R.id.ksb;
                                case 601:
                                    return R.id.hod;
                                case 602:
                                    return R.id.hoa;
                                case 603:
                                    return R.id.hof;
                                case 604:
                                    return R.id.hoe;
                                case 605:
                                    return R.id.hob;
                                case 606:
                                    return R.id.hog;
                                case 607:
                                    return R.id.hny;
                                case 608:
                                    return R.id.hnx;
                                case 609:
                                    return R.id.hnz;
                                case 610:
                                    return R.id.f166750hu2;
                                case 611:
                                    return R.id.f166749hu1;
                                case 612:
                                    return R.id.f166748hu0;
                                case 613:
                                    return R.id.htx;
                                case 614:
                                    return R.id.htz;
                                case 615:
                                    return R.id.htw;
                                case 616:
                                    return R.id.hty;
                                case 617:
                                    return R.id.kqb;
                                case 618:
                                    return R.id.kqa;
                                case 619:
                                    return R.id.f167105kx0;
                                case 620:
                                    return R.id.f167109kx4;
                                case 621:
                                    return R.id.kx6;
                                case 622:
                                    return R.id.f166525fv4;
                                case 623:
                                    return R.id.kx7;
                                case 624:
                                    return R.id.f167107kx2;
                                case 625:
                                    return R.id.f167108kx3;
                                case 626:
                                    return R.id.ksq;
                                case 627:
                                    return R.id.hii;
                                case 628:
                                    return R.id.kx5;
                                case 629:
                                    return R.id.l0w;
                                case 630:
                                    return R.id.f167106kx1;
                                case 631:
                                    return R.id.fix;
                                case 632:
                                    return R.id.fiz;
                                case 633:
                                    return R.id.f166487fj0;
                                case 634:
                                    return R.id.fiw;
                                default:
                                    return 0;
                            }
                    }
            }
        }
        return R.id.hnt;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources
    public int getColor(int i3) {
        int i16;
        switch (i3) {
            case 1639:
                i16 = R.color.f156605c;
                break;
            case 1640:
                i16 = R.color.f156678m;
                break;
            case 1641:
                i16 = R.color.f156646i;
                break;
            case 1642:
                i16 = R.color.f156606d;
                break;
            default:
                i16 = 0;
                break;
        }
        try {
            return PlayerConfig.g().getAppContext().getResources().getColor(i16);
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources
    public String getString(int i3) {
        int i16;
        switch (i3) {
            case 1366:
                i16 = R.string.gaf;
                break;
            case 1367:
                i16 = R.string.gag;
                break;
            case 1368:
                i16 = R.string.gom;
                break;
            case 1369:
                i16 = R.string.gon;
                break;
            case 1370:
                i16 = R.string.gl6;
                break;
            case 1371:
                i16 = R.string.gl5;
                break;
            case 1372:
                i16 = R.string.gl7;
                break;
            case 1373:
                i16 = R.string.gkz;
                break;
            case q.CTRL_INDEX /* 1374 */:
                i16 = R.string.f173033gl4;
                break;
            case 1375:
            default:
                i16 = 0;
                break;
            case 1376:
                i16 = R.string.gky;
                break;
            case 1377:
                i16 = R.string.gkv;
                break;
            case 1378:
                i16 = R.string.f173029gl0;
                break;
            case 1379:
                i16 = R.string.f173030gl1;
                break;
            case 1380:
                i16 = R.string.f173031gl2;
                break;
            case 1381:
                i16 = R.string.gkw;
                break;
            case 1382:
                i16 = R.string.gkx;
                break;
            case 1383:
                i16 = R.string.gl8;
                break;
            case 1384:
                i16 = R.string.f173032gl3;
                break;
        }
        try {
            return PlayerConfig.g().getAppContext().getResources().getString(i16);
        } catch (Exception unused) {
            return "";
        }
    }
}
